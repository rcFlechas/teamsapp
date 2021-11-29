package com.rcflechas.teamsapp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rcflechas.teamsapp.R
import com.rcflechas.teamsapp.core.observeEvent
import com.rcflechas.teamsapp.databinding.FragmentTeamsBinding
import com.rcflechas.teamsapp.presentation.adapters.TeamAdapter
import com.rcflechas.teamsapp.presentation.binds.TeamBind
import com.rcflechas.teamsapp.presentation.viewmodels.TeamsViewModel
import com.rcflechas.teamsapp.utilities.UIState
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamsFragment : Fragment() {

    private var _binding: FragmentTeamsBinding? = null
    private val binding get() = _binding

    private val teamsViewModel: TeamsViewModel by viewModel()
    private lateinit var  teamAdapter: TeamAdapter

    private val SPANISH_LA_LIGA = "Spanish La Liga"

    private fun handlerIsGetByLeagueName(state: UIState<List<TeamBind>>){

        when (state) {
            is UIState.OnLoading -> {
                isLoading(state.loading)
            }

            is UIState.OnSuccess -> {
                isLoading(false)

                teamAdapter.clearData()
                val data = state.data
                if (data.isNotEmpty()) {
                    dataNoEmpty()
                    teamAdapter.setData(data)
                } else {
                    dataEmpty(getString(R.string.message_list_empty))
                }
            }

            is UIState.OnError -> {
                isLoading(false)
                dataEmpty(state.error)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupUI()
        setupAdapters()
        setupEvents()
        setupObserveEvents()
        teamsViewModel.getByLeagueName(SPANISH_LA_LIGA)
    }

    private fun setupToolbar() {
        binding?.toolbar?.setTitle(R.string.app_name)
    }

    private fun setupUI() {
    }

    private fun setupAdapters() {

        teamAdapter = TeamAdapter (clickClosure = {

            val bundle = bundleOf(TeamBind.TAG to it)
            findNavController().navigate(R.id.action_teamsFragment_to_teamDetailFragmentDialog, bundle)
        })
        teamAdapter.setHasStableIds(true)
        binding?.teamRecyclerView?.apply {
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL))
            setHasFixedSize(true)
            adapter = teamAdapter
        }
    }

    private fun setupEvents() {

    }

    private fun setupObserveEvents() {
        teamsViewModel.getByLeagueName.observeEvent(viewLifecycleOwner) {
            handlerIsGetByLeagueName(it)
        }
    }

    private fun isLoading(loading: Boolean) {
        binding?.progressBar?.visibility = if (loading) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun dataEmpty(text: String = String()) {
        binding?.teamRecyclerView?.visibility = View.GONE
        binding?.includeEmptyView?.root?.visibility = View.VISIBLE
        binding?.includeEmptyView?.emptyTextView?.text = text
    }

    private fun dataNoEmpty() {
        binding?.teamRecyclerView?.visibility = View.VISIBLE
        binding?.includeEmptyView?.root?.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        teamsViewModel.closeSubscriptions()
    }
}