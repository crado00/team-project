import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Button from "../components/ui/Button";
import Input from "../components/ui/Input";
import useAuthStore from "../store/authStore";

const Login = () => {
  const navigate = useNavigate();

  const { login, loading, error } = useAuthStore();

  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });

  const isEmail = (value) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const loginData = isEmail(formData.email)
        ? { email: formData.email, password: formData.password }
        : { username: formData.email, password: formData.password };

      console.log(loginData);
      await login(loginData);
      navigate("/");
    } catch (err) {
      console.error(err);
    }
  };

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };


  return (
    <div className="min-h-screen flex flex-col justify-center items-center bg-gradient-to-br from-green-500 to-blue-300">
      <div className="max-w-[420px] space-y-6 my-12">
        <div className="bg-white/95 backdrop-blur-sm rounded-3xl shadow-2xl px-12 py-14">
          <h1 className="text-center mb-6">
            <span className="text-5xl bg-gradient-to-r from-green-500 to-blue-300 bg-clip-text text-transparent">
              Spotify
            </span>
          </h1>

          <form className="space-y-4" onSubmit={handleSubmit}>
            <Input
              type="text"
              name="email"
              placeholder="Email"
              value={formData.email}
              onChange={handleChange}
              required
            />

            <Input
              type="password"
              name="password"
              placeholder="Password"
              value={formData.password}
              onChange={handleChange}
              required
            />

            <Button
              className="mt-4"
              type="submit"
              disabled={
                loading || !formData.emailOrUsername || !formData.password
              }
            >
              {loading ? "Logging in..." : "Log in"}
            </Button>
          </form>

          {error && (
            <p className="text-red-500 text-xs text-center mt-4">{error}</p>
          )}

          <div className="flex items-center my-8">
            <div className="flex-1 h-px bg-gradient-to-r from-transparent via-gray-300 to-transparent"></div>
            <span className="px-4 text-gray-500 text-sm font-medium">OR</span>
            <div className="flex-1 h-px bg-gradient-to-r from-transparent via-gray-300 to-transparent"></div>
          </div>


          <Link
            to="/forgot-password"
            className="block text-center text-base text-gray-600 hover:text-pink-500 transition-colors mt-8"
          >
            Forgot password?
          </Link>
        </div>

        <div className="bg-white/95 backdrop-blur-sm rounded-3xl shadow-xl px-12 py-8 text-center">
          <p className="text-gray-600">
            Don't have an account?{" "}
            <Link
              to="/signup"
              className="bg-gradient-to-r from-green-600 to-blue-600 bg-clip-text text-transparent font-semibold hover:from-green-700 hover:to-blue-700 transition-all "
            >
              Sign up
            </Link>
          </p>
        </div>

      </div>
    </div>
  );
};

export default Login;
