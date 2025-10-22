const StorageKeys = {
  ACCESS_TOKEN: "accessToken",
  REFRESH_TOKEN: "refreshToken",
  USER: "user",
};

const StorageService = {
  getAccessToken: () => localStorage.getItem(StorageKeys.ACCESS_TOKEN),
  setAccessToken: (token) =>
    localStorage.setItem(StorageKeys.ACCESS_TOKEN, token),
  getRefreshToken: () => localStorage.getItem(StorageKeys.REFRESH_TOKEN),
  setRefreshToken: (token) =>
    localStorage.setItem(StorageKeys.REFRESH_TOKEN, token),
  getUser: () => {
    const user = localStorage.getItem(StorageKeys.USER);
    return user ? JSON.parse(user) : null;
  },
  setUser: (user) =>
    localStorage.setItem(StorageKeys.USER, JSON.stringify(user)),
  clear: () => {
    Object.values(StorageKeys).forEach((key) => {
      localStorage.removeItem(key);
    });
  },
};

export default StorageService;