import React from 'react';
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from './pages/home';
import Login from './pages/login';
import Signup from './pages/signup';

const App = () => {

  return (
    <BrowserRouter>
      <nav className="flex justify-center items-center h-48 bg-gray-300">
        <Link to="/">홈</Link> | <Link to="/login">로그인</Link> | <Link to="/signup">회원가입</Link>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App;