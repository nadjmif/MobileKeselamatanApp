package com.example.nadjmi_3tic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nadjmi_3tic.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireActivity().getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        val savedUsername = sharedPref.getString("username", "Nadjmi") ?: "Nadjmi"
        binding.tvHomeGreeting.text = "Halo, $savedUsername!"

        binding.cardKebakaranHome.setOnClickListener {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            startActivity(intent)
        }

        binding.btnHomeLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi LogOut")
                .setMessage("Apakah kamu yakin ingin keluar dari aplikasi?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    sharedPref.edit().putBoolean("isLogin", false).apply()
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
