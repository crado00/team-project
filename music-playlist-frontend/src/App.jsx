import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import Profile from "./pages/profile";
const App = () => {

  return (
      <BrowserRouter>
        <Routes>
          <Route path="/profile" element={<Profile />} />
        </Routes>
      </BrowserRouter>
  )
}

export default App
