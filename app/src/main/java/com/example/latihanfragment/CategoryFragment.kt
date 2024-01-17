package com.example.latihanfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.latihanfragment.DetailCategoryFragment.Companion.EXTRA_NAME

class CategoryFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory: Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)
    }

    //Mengirim Data Antar Fragment
    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_detail_category) {
            val detailCategoryFragment = DetailCategoryFragment()

            //Pembungkus bisa juga untuk kls map data string untuk obyek parcelable
            //Maping = key & value
            //dapat input >1 parameter/variabel ke dalam bundle
            val bundle = Bundle()
            bundle.putString(EXTRA_NAME, "Lifestyle")
            val description = "Kategori ini akan berisi produk-produk lifestyle"

            detailCategoryFragment.arguments = bundle
            detailCategoryFragment.description = description

            //Dapat membuat instance-instance baru
            val fragmentManager = parentFragmentManager
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, detailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}