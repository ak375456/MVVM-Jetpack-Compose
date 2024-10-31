package com.example.realviewmodel.store.presentation.products_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.realviewmodel.store.presentation.products_screen.component.ProductCard
import com.example.realviewmodel.store.presentation.util.componenets.LoadingDialog
import com.example.realviewmodel.store.presentation.util.componenets.MyTopAppBar

@Composable
internal fun ProductsScreen(
    viewModel:ProductsViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductsContent(state = state)

}

@Composable
fun ProductsContent(
    state:ProductViewState
){
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppBar(title = "Products")
        },

    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ) {
            items(state.products){products->
                ProductCard(product = products)
            }
        }
    }
}