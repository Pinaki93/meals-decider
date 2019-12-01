package dev.pinaki.mealdecider.ui.bottomsheets

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textview.MaterialTextView
import dev.pinaki.mealdecider.R
import dev.pinaki.mealdecider.databinding.SingleChoiceBottomSheetBinding

/*
*TODO:
* 1. Make the dialog full screen
* */
data class SingleChoiceBottomSheetItem(
    val id: Int,
    val title: String,
    var selected: Boolean
)

interface SingleChoiceBottomSheetListener {
    fun onItemSelected(item: SingleChoiceBottomSheetItem)
}


@Suppress("UNCHECKED_CAST")
class SingleChoiceBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private lateinit var title: String
    private lateinit var items: MutableList<SingleChoiceBottomSheetItem>

    private var listener: SingleChoiceBottomSheetListener? = null

    private lateinit var adapter: SingleChoiceRecyclerAdapter
    private lateinit var binding: SingleChoiceBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments == null) {
            dismissAllowingStateLoss()
        }

        arguments?.apply {
            title = getString(ARG_TITLE)!!
            items = getSerializable(ARG_ITEMS) as ArrayList<SingleChoiceBottomSheetItem>
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is SingleChoiceBottomSheetListener) {
            listener = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.bottom_sheet_single_choice,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text = title
        binding.rvSingleChoice.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )

        adapter = SingleChoiceRecyclerAdapter(binding.rvSingleChoice)
        adapter.items = items

        binding.rvSingleChoice.adapter = adapter

        adapter.onItemClick = { position ->
            listener?.onItemSelected(items[position])
            dismissAllowingStateLoss()
        }
    }

    companion object {

        const val TAG = "SingleChoiceBottomSheetDialogFragment"

        private const val ARG_TITLE = "title"
        private const val ARG_ITEMS = "items"

        fun getInstance(
            title: String,
            items: ArrayList<SingleChoiceBottomSheetItem>
        ): SingleChoiceBottomSheetDialogFragment {
            val instance = SingleChoiceBottomSheetDialogFragment()
            instance.arguments = Bundle().apply {
                putString(ARG_TITLE, title)
                putSerializable(ARG_ITEMS, items)
            }

            return instance
        }
    }
}


class SingleChoiceRecyclerAdapter(private val recyclerView: RecyclerView) :
    RecyclerView.Adapter<SingleChoiceRecyclerAdapter.ItemViewHolder>(), View.OnClickListener {

    public var items: MutableList<SingleChoiceBottomSheetItem> = ArrayList()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    public var onItemClick: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_choice_item, parent, false)
        itemView.setOnClickListener(this)

        return ItemViewHolder(itemView)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setItem(items[position])

    }

    override fun onClick(v: View?) {
        v?.let {
            onItemClick?.run {
                invoke(recyclerView.getChildLayoutPosition(v))
            }
        }
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivChoosen: AppCompatImageView = itemView.findViewById(R.id.iv_choosen)
        private val tvItemName: MaterialTextView = itemView.findViewById(R.id.tv_item_name)

        fun setItem(item: SingleChoiceBottomSheetItem) {
            ivChoosen.visibility = if (item.selected) View.VISIBLE else View.INVISIBLE
            tvItemName.text = item.title
        }
    }

}