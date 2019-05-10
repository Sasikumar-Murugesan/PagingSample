package com.sasi.simplepagingsample.model



data class UserItem(
    var hasMore: Boolean = false,
    var items: List<Item> = listOf(),
    var quotaMax: Int = 0,
    var quotaRemaining: Int = 0
) {
    data class Item(
        var acceptRate: Int = 0,
        var accountId: Int = 0,
        var badgeCounts: BadgeCounts = BadgeCounts(),
        var creationDate: Int = 0,
        var displayName: String = "",
        var isEmployee: Boolean = false,
        var lastAccessDate: Int = 0,
        var lastModifiedDate: Int = 0,
        var link: String = "",
        var location: String = "",
        var profileImage: String = "",
        var reputation: Int = 0,
        var reputationChangeDay: Int = 0,
        var reputationChangeMonth: Int = 0,
        var reputationChangeQuarter: Int = 0,
        var reputationChangeWeek: Int = 0,
        var reputationChangeYear: Int = 0,
        var userId: Int = 0,
        var userType: String = "",
        var websiteUrl: String = ""
    ) {
        data class BadgeCounts(
            var bronze: Int = 0,
            var gold: Int = 0,
            var silver: Int = 0
        )
    }
    // Data Model for the Response returned from the TMDB Api
    data class UserResponse(
        val results: List<UserItem>
    )
}