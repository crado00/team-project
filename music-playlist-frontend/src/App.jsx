import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import Profile from "./pages/profile";
import Home from "./pages/home";
const App = () => {

  return (
      <BrowserRouter>
        <Routes>
          <Route path="/profile" element={<Profile />} />
          <Route path="/" element={<Home />} />
        </Routes>
      </BrowserRouter>
  )
}

export default App
