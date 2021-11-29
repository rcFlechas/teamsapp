package com.rcflechas.teamsapp.presentation.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.rcflechas.teamsapp.R
import com.rcflechas.teamsapp.core.onClick
import com.rcflechas.teamsapp.core.setHttps
import com.rcflechas.teamsapp.core.setImageByUrl
import com.rcflechas.teamsapp.databinding.FragmentTeamDetailDialogBinding
import com.rcflechas.teamsapp.presentation.binds.TeamBind
import com.rcflechas.teamsapp.presentation.viewmodels.TeamDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class TeamDetailDialogFragment : DialogFragment() {

    private var _binding: FragmentTeamDetailDialogBinding? = null
    private val binding get() = _binding

    private val movieDetailViewModel: TeamDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)

        arguments?.getParcelable<TeamBind>(TeamBind.TAG)?.let { team ->
            movieDetailViewModel.teamBind = team
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): CoordinatorLayout? {
        // Inflate the layout for this fragment
        _binding = FragmentTeamDetailDialogBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar(view)
        setupUI()
        setupEvents()
    }

    private fun setupToolbar(view: View) {
        binding?.toolbar?.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close_24)
        binding?.toolbar?.setTitleTextColor(Color.WHITE)
        binding?.toolbar?.setNavigationOnClickListener {
            dismiss()
        }
    }

    private fun setupUI() {
        movieDetailViewModel.teamBind?.run {

            binding?.includeCardsBadgeJersey?.badgeImageView?.setImageByUrl(
                url = this.badge
            )

            binding?.includeCardsBadgeJersey?.jerseyImageView?.setImageByUrl(
                url = this.jersey
            )
            binding?.includeCardsSocialNetwork?.name?.text = "${this.name} (${this.foundedYear})"
            binding?.includeCardsSocialNetwork?.websiteTextView?.text = this.website
            binding?.includeCardsDescription?.descriptionTextView?.text = this.description
        }
    }

    private fun setupEvents() {

        binding?.includeCardsSocialNetwork?.websiteContent?.onClick {
            movieDetailViewModel.teamBind?.run {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(website.setHttps()))
                startActivity(browserIntent)
            }
        }

        binding?.includeCardsSocialNetwork?.facebookContent?.onClick {
            movieDetailViewModel.teamBind?.run {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(facebook.setHttps()))
                startActivity(browserIntent)
            }
        }

        binding?.includeCardsSocialNetwork?.instagramContent?.onClick {
            movieDetailViewModel.teamBind?.run {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(instagram.setHttps()))
                startActivity(browserIntent)
            }
        }

        binding?.includeCardsSocialNetwork?.twitterContent?.onClick {
            movieDetailViewModel.teamBind?.run {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(twitter.setHttps()))
                startActivity(browserIntent)
            }
        }

        binding?.includeCardsSocialNetwork?.youtobeContent?.onClick {
            movieDetailViewModel.teamBind?.run {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(youtube.setHttps()))
                startActivity(browserIntent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}