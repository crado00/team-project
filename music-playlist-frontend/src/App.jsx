import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import Profile from "./pages/profile";
import EditProfile from "./pages/editProfile";
const App = () => {

  return (
      <BrowserRouter>
        <Routes>
          <Route path="/profile" element={<Profile />} />
          <Route path="/edit" element={<EditProfile />} />

        </Routes>
      </BrowserRouter>
  )
}

export default App
