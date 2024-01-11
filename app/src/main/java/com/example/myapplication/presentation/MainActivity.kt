package com.example.myapplication.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.commons.Resource
import com.example.myapplication.domain.model.Coin
import com.example.myapplication.presentation.listCoins.CoinListViewModel
import com.example.myapplication.presentation.listCoins.components.CoinItemList
import com.example.myapplication.presentation.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private val coinListViewModel: CoinListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface {
                    val coins = coinListViewModel.getCoinLive.collectAsState(initial = Resource.Loading(data = emptyList()))
                    when (coins.value) {
                        is Resource.Error -> {
                            Log.d(TAG, "onCreate: error")
                        }
                        is Resource.Loading -> {
                            Log.d(TAG, "onCreate: loading")
                            CircularProgressIndicator(Modifier.size(30.dp), color = MaterialTheme.colorScheme.onPrimary)
                        }
                        is Resource.Success -> {
                            val state = rememberLazyListState()
                            LazyColumn(state = state, contentPadding = PaddingValues(12.dp , 4.dp)){
                                coins.let { coins->
                                    items(coins.value.data?.size!!){
                                        CoinItemList(coin = coins.value.data!![it], clickacle = {

                                        })
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}
