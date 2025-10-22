import React, { useState } from 'react';
import useAuthStore from '../store/authStore';

function Signup() {
  const [form, setForm] = useState({
    username: "",
    fullname: '',
    email: '',
    password: '',
    confirmPassword: '',
  });

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    if (form.password !== form.confirmPassword) {
      alert("비밀번호가 일치하지 않습니다.");
      return;
    }

    useAuthStore.getState().register(form)
      .then((data) => {
        console.log("회원가입 성공:", data);
        // 회원가입 성공 후 처리 (예: 로그인 페이지로 이동)
      })
      .catch((err) => {
        console.error("회원가입 실패:", err);
        // 회원가입 실패 후 처리 (예: 에러 메시지 표시)
      });

    console.log("회원가입 정보:", form);
    // 실제 회원가입 API 요청 코드 작성 위치
  };


  
  return (
    <div className="bg-white p-8 rounded-lg shadow-md w-full max-w-sm">
      <h2 className="text-2xl font-bold mb-6 text-center">회원가입</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
          <input
          type="text"
          name="username"
          placeholder="username"
          value={form.name}
          onChange={handleChange}
          required
          className="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
        />
        <input
          type="text"
          name="fullname"
          placeholder="fullname"
          value={form.name}
          onChange={handleChange}
          required
          className="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
        />
        <input
          type="email"
          name="email"
          placeholder="email"
          value={form.email}
          onChange={handleChange}
          required
          className="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
        />
        <input
          type="password"
          name="password"
          placeholder="password"
          value={form.password}
          onChange={handleChange}
          required
          className="w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
        />
        <button
          type="submit"
          className="w-full bg-blue-600 text-white py-2 rounded-md hover:bg-blue-700 transition duration-200"
        >
          회원가입
        </button>
      </form>
    </div>
  );
}

export default Signup;
