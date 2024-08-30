package br.com.fiap.listadecompras

data class ItemModel(
    val name: String,
    val onRemove: (ItemModel) -> Unit = { _ -> }
)