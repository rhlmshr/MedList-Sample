package com.medcords.sample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.medcords.sample.R
import com.medcords.sample.network.models.Cm
import com.medcords.sample.network.models.ListEntity
import com.medcords.sample.network.models.ResponseState
import com.medcords.sample.ui.adapters.MedListAdapter
import com.medcords.sample.utils.getViewModel
import com.medcords.sample.utils.toastShort
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private val viewModel by lazy { getViewModel<MainViewModel>() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvList.adapter = MedListAdapter()

        setListeners()

        viewModel
    }

    private fun setListeners() {
        viewModel.medsLiveData.observe(this, Observer { res ->
            if (res is ResponseState.Success<*>)
                (rvList.adapter as MedListAdapter).submitList(res.data as List<ListEntity>)
        })
    }
}