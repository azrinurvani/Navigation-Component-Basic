package com.mobile.azrinurvani.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import kotlinx.android.synthetic.main.fragment_confirmations.*


class ConfirmationsFragment : Fragment() {

    private lateinit var recipientName :String
    private lateinit var money: Money


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipientName = arguments?.getString("recipient").toString()
        money = arguments?.getParcelable<Money>("amount")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmations, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val amount = money?.amount
        val confirmMessage = "You have sent $amount to $recipientName"

        confirmation_message.text = confirmMessage

    }



}