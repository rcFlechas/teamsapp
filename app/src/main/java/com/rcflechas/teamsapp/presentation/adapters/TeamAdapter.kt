package com.rcflechas.teamsapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.DiffResult.NO_POSITION
import com.bumptech.glide.request.RequestOptions
import com.rcflechas.teamsapp.core.onClick
import com.rcflechas.teamsapp.core.setImageByUrl
import com.rcflechas.teamsapp.databinding.ItemTeamBinding
import com.rcflechas.teamsapp.presentation.binds.TeamBind

class TeamAdapter (
    val clickClosure: (TeamBind) -> Unit
) : CustomAdapter<TeamBind, TeamAdapter.ViewHolder>() {

    private var dataItems = arrayListOf<TeamBind>()

    fun setData(teams: List<TeamBind>) {

        dataItems.clear()
        dataItems.addAll(teams)
        elements.clear()
        elements.addAll(teams)
        notifyDataSetChanged()
    }

    fun getData(): MutableList<TeamBind> {
        return elements
    }

    fun clearData() {
        this.dataItems.clear()
        this.elements.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ViewHolder(binding)

        binding.root.onClick {

            val position = holder.adapterPosition.takeIf { it != NO_POSITION } ?: return@onClick
            clickClosure(elements[position])
        }

        return holder
    }

    override fun getItemCount(): Int {
        return elements.count()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val teamBind = elements[position]

        when (holder) {
            is ViewHolder -> holder.bind(teamBind)
        }
    }

    override fun getItemId(position: Int): Long {
        return elements[position].id
    }

    fun getItem(position: Int): TeamBind {
        return elements[position]
    }

    inner class ViewHolder(private val binding: ItemTeamBinding) : BaseViewHolder<TeamBind>(binding.root) {

        override fun bind(item: TeamBind) {

            binding.badgeImageView.setImageByUrl(
                url = "${item.badge}/preview",
                options = RequestOptions().centerCrop()
            )
            binding.nameTextView.text = item.name
            binding.stadiumTextView.text = item.stadium
        }
    }
}