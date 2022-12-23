package banyuwangi.digital.admin.ui.navigation

sealed class Screen(val title: String, val route: String) {
    object Home : Screen("home", "home")
    object Attraction : Screen("attraction", "attraction")
    object AttractionDetail : Screen("Detail Attraction", "attraction/{id}?data={data}") {
        fun createRoute(id: String, attraction:String?) = "attraction/$id?data=$attraction"
    }

    object Homestay : Screen("homestay", "homestay")
}