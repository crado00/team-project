import api from "./api";

const PlayListService = {
    /*
    getAllPlaylists: async () => {
        const response = await api.get('/api/playlists');
        return response.data;
    },
    getPlaylistById: async (playlistId) => {
        const response = await api.get(`/api/lay-list/${playlistId}`);
        return response.data;
    },
*/
    getPlaylistByUserId: async (userId) => {
        const response = await api.get(`/api/lay-list/user/${userId}`);
        return response.data;
    },
    createPlaylist: async (data) => {
        const response = await api.post('/api/play-list', data);
        return response.data;
    },
    updatePlaylist: async (playlistId, data) => {
        const response = await api.post(`/api/play-list/${playlistId}`, data);
        return response.data; // api url이 변경될 수 있어보임
    },
    deletePlaylist: async (playlistId) => {
        const response = await api.delete(`/api/play-list/${playlistId}`);
        return response.data;
    }
};

export default PlayListService;