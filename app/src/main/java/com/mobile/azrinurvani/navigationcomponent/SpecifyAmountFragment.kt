package com.mobile.azrinurvani.navigationcomponent

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment() {

    private lateinit var navController : NavController
    private lateinit var recipientName : String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipientName = arguments?.getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        send_btn.setOnClickListener {

            if (!TextUtils.isEmpty(input_amount.text.toString())){
                val amount = Money(BigDecimal(input_amount.text.toString()))
                val bundle = bundleOf(
                    "recipient" to recipientName,
                    "amount" to amount
                )
                navController.navigate(R.id.action_specifyAmountFragment_to_confirmationsFragment,bundle)
            }else{
                Toast.makeText(activity,"Enter an amount",Toast.LENGTH_SHORT).show()
            }

        }
        cancel_btn.setOnClickListener {
            activity?.onBackPressed()
        }

        val message = "Sending money to $recipientName"

        recipient.text = message
    }


}