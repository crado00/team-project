import React from "react";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import Home from "./pages/home";
import Signup from "./pages/signup";
import Login from "./pages/login";
import Profile from "./pages/profile";
import EditProfile from "./pages/editProfile";
import useAuthStore from "./store/authStore";

const App = () => {
  const { isAuthenticated } = useAuthStore();

  return (
    <BrowserRouter>
      <Routes>
        {/* 로그인 관련 */}
        <Route
          path="/"
          element={isAuthenticated ? <Navigate to="/" /> : <Home />}
        />
        <Route
          path="/login"
          element={isAuthenticated ? <Navigate to="/" /> : <Login />}
        />
        <Route
          path="/signup"
          element={isAuthenticated ? <Navigate to="/" /> : <Signup />}
        />

        {/* 프로필 관련 */}
        <Route path="/profile" element={<Profile />} />
        <Route path="/edit" element={<EditProfile />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App;

