package com.medcords.sample.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.medcords.sample.databinding.RowMedListBinding
import com.medcords.sample.network.models.Cm
import com.medcords.sample.utils.executeAfter
import com.medcords.sample.utils.toastShort

class MedListAdapter : ListAdapter<Cm, MedListAdapter.ViewHolder>(MedListDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.create(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.executeAfter {
            val entity = getItem(position)
            currItem = entity
            root.setOnClickListener { root.context.toastShort(currItem.hi) }
        }
    }

    class ViewHolder(val binding: RowMedListBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    RowMedListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
        }
    }
}

object MedListDiffCallback : DiffUtil.ItemCallback<Cm>() {
    override fun areItemsTheSame(oldItem: Cm, newItem: Cm) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Cm, newItem: Cm) = oldItem == newItem
}