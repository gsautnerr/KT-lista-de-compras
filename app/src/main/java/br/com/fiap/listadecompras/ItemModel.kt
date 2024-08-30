package br.com.fiap.listadecompras

data class ItemModel(
    val id : Int,
    val name: String,
    val onRemove: (ItemModel) -> Unit 
)