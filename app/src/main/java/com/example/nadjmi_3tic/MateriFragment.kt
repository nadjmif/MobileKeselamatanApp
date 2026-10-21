package com.example.nadjmi_3tic

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nadjmi_3tic.databinding.FragmentMateriBinding

class MateriFragment : Fragment() {
    private var _binding: FragmentMateriBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMateriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val materiList = listOf(
            MateriModel("Cara Menggunakan APAR yang Benar", "Video tutorial penggunaan APAR dalam situasi kebakaran.", "Video", R.drawable.user_2),
            MateriModel("Tas Siaga Bencana di Rumah", "Apa saja yang perlu disiapkan dalam tas siaga bencana.", "Artikel", R.drawable.user_2),
            MateriModel("Kenali Tanda-Tanda Tsunami", "Pelajari ciri-ciri awal tsunami dan langkah evakuasi.", "Infografis", R.drawable.user_2)
        )

        val adapter = MateriAdapter(requireContext(), materiList)
        binding.listViewMateri.adapter = adapter

        binding.listViewMateri.setOnItemClickListener { _, _, _, _ ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
