package com.mobile.azrinurvani.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view_transactions_btn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
        }
        send_money_btn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_chooserRecipientFragment)
        }
        view_balance_btn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }

    }




}