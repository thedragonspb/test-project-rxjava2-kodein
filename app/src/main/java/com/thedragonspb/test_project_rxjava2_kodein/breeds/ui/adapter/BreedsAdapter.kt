package com.thedragonspb.test_project_rxjava2_kodein.breeds.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thedragonspb.test_project_rxjava2_kodein.R


class BreedsAdapter(
    private val onItemClickedListener: ((String) -> Unit)?
) : RecyclerView.Adapter<BreedsAdapter.BreedViewHolder>() {

    private val breeds: MutableList<Breed> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder.create(
            parent,
            onItemClickedListener
        )
    }

    override fun getItemCount(): Int = breeds.size

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        holder.bind(breeds[position])
    }

    fun submitList(breedsList: List<Breed>) {
        breeds.apply {
            clear()
            addAll(breedsList)
        }
        notifyDataSetChanged()
    }

    class BreedViewHolder(
        private val view: View,
        private val onItemClickedListener: ((String) -> Unit)?
    ) : RecyclerView.ViewHolder(view) {

        private val context = view.context
        private val titleText = view.findViewById<TextView>(R.id.titleText)
        private val subbreedCountText = view.findViewById<TextView>(R.id.countText)

        fun bind(breed: Breed) {
            val subbreedCount = breed.subbreeds.size

            titleText.text = breed.name
            subbreedCountText.text = subbreedCount.toString()

            if (subbreedCount == 0) {
                subbreedCountText.visibility = View.GONE
            } else {
                subbreedCountText.text =
                    context.getString(R.string.subreeds_count, subbreedCount)
            }

            view.setOnClickListener {
                onItemClickedListener?.invoke(breed.name)
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onItemClickedListener: ((String) -> Unit)?
            ): BreedViewHolder {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_list, parent, false)

                return BreedViewHolder(
                    view,
                    onItemClickedListener
                )
            }
        }

    }
}