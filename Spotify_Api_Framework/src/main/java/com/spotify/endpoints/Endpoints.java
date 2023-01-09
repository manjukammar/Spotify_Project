package com.spotify.endpoints;

public class Endpoints {
   
	/*Albums*/
	public static String Album="/albums/{id}";
	public static String Albums="/albums";
	public static String AlbumTracs="/albums/{id}/tracks";
	public static String UsersavedAlbum="me/albums";
	public static String CheckUsersavedAlbums="me/albums/contains";
	public static String NewRelease="/browse/new-releases";
	
	/*Artists*/
	public static String Artist="/artists/{id}";
	public static String Artists="/artists/";
	public static String ArtistAlbum="/artists/{id}/albums";
	public static String ArtistTopTracks="/artists/{id}/top-tracks?market=IN";
	public static String ArtistRelatedArists="/artists/{id}/related-artists";
	
	/*Play list*/
	public static String CreatePlaylist="/users/{user_id}/playlists";
	public static String Playlist="/playlists/{playlist_id}";
	public static String ChangePlaylistDetails="/playlists/{playlist_id}";
	public static String PlaylistItems="/playlists/{playlist_id}/tracks";
	
	
	/*Markets*/
	public static String Markets="markets";
	
	/*Categories*/
	public static String SeveralBrowsecategories="/browse/categories";
	public static String SingleBrowsecategories="/browse/categories/0JQ5DAqbMKFKSopHMaeIeI";
	
	/*Search*/
	public static String Search="/search";
	
	/* Shows */
	public static String Show="/shows/{id}";
	public static String Shows="/shows";
	public static String ShowsEpisode="/shows/{id}/episodes";
	public static String SavedShow="me/shows";
	public static String CheckSavedShow="me/shows/contains";
	
	/* Episodes */
	public static String Episode="/episodes/{id}";
	public static String SavedEpisode="me/episodes";
	public static String CheckSavedEpisode="me/episodes/contains";
	
	/* Tracks */
	public static String Track="/tracks/{id}";
	public static String Tracks="/tracks";
	public static String SavedTracks="me/tracks";
	public static String CheckSavedTracks="me/tracks/contains";
	
	/* User */
	public static String User="/me";
	public static String UserTopItems="/me/top/{type}";
	public static String UserProfile="/users/{user_id}";
	public static String UserFollowing="/me/following";
	public static String UserFollowingPlayList="/playlists/{playlist_id}/followers";
}
