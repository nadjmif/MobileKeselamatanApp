package com.example.nadjmi_3tic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nadjmi_3tic.databinding.FragmentKontakBinding

class KontakFragment : Fragment() {
    private var _binding: FragmentKontakBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentKontakBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val kontakList = listOf(
            KontakModel("RS. Harapan Bunda", "Rumah Sakit", "1.2 km • 5 menit", R.drawable.user_2),
            KontakModel("Pos Pemadam Kebakaran", "Pemadam Kebakaran", "1.8 km • 7 menit", R.drawable.user_2),
            KontakModel("Polsek Sukamaju", "Polisi", "2.4 km • 10 menit", R.drawable.user_2)
        )

        val adapter = KontakAdapter(requireContext(), kontakList)
        binding.listViewKontak.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
