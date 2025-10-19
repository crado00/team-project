import PlayListService from "../services/Playlist";
import { create } from "zustand";

const usePlaylistStore = create((set) => ({
    playlists: [],
    loading: false,
    error: null,

    getPlaylistsByUserId: async (userId) => {
        set({ loading: true, error: null });
        try {
            const playlists = await PlayListService.getPlaylistByUserId(userId);
            set({
                playlists,
                loading: false,
            });
            return { playlists };
        }
        catch (err) {
            set({
                error: err.response?.data.message || "Failed to get playlists",
                loading: false,
            });
            throw err;
        }
    },

    createPlaylist: async (data) => {
        set({ loading: true, error: null });
        try {
            const newPlaylist = await PlayListService.createPlaylist(data);             
            set((state) => ({
                playlists: [...state.playlists, newPlaylist],
                loading: false,
            }));
            return { newPlaylist };
        }
        catch (err) {
            set({
                error: err.response?.data.message || "Failed to create playlist",
                loading: false,
            });
            throw err;
        }
    },
    updatePlaylist: async (playlistId, data) => {
        set({ loading: true, error: null });
        try {
            const updatedPlaylist = await PlayListService.updatePlaylist(playlistId, data);
            set((state) => ({
                playlists: state.playlists.map((pl) =>
                    pl.id === playlistId ? updatedPlaylist : pl
                ),
                loading: false,
            }));
            return { updatedPlaylist };
        }
        catch (err) {
            set({
                error: err.response?.data.message || "Failed to update playlist",
                loading: false,
            });
            throw err;
        }
    },

    deletePlaylist: async (playlistId) => {
        set({ loading: true, error: null });
        try {
            await PlayListService.deletePlaylist(playlistId);
            set((state) => ({
                playlists: state.playlists.filter((pl) => pl.id !== playlistId),
                loading: false,
            }));
        }
        catch (err) {
            set({
                error: err.response?.data.message || "Failed to delete playlist",
                loading: false,
            });
            throw err;
        }
    },
}));

export default usePlaylistStore;