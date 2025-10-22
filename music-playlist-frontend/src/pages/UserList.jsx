import { useEffect, useState } from "react";

const UserList = () => {
  const [users, setUsers] = useState([]);         // 데이터 저장
  const [loading, setLoading] = useState(true);   // 로딩 상태
  const [error, setError] = useState(null);       // 에러 상태

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const res = await fetch("https://jsonplaceholder.typicode.com/users");
        if (!res.ok) throw new Error("서버 오류 발생");
        const data = await res.json();
        setUsers(data);          // 데이터 설정
      } catch (err) {
        setError(err.message);   // 에러 설정
      } finally {
        setLoading(false);       // 로딩 종료
      }
    };

    fetchUsers(); // 마운트 시 실행
  }, []);

  if (loading) return <p>⏳ 사용자 목록 불러오는 중...</p>;
  if (error) return <p>❌ 오류 발생: {error}</p>;

  return (
    <div>
      <h2>👥 사용자 목록</h2>
      <ul>
        {users.map((user) => (
          <li key={user.id}>
            {user.name} ({user.email})
          </li>
        ))}
      </ul>
    </div>
  );
};

export default UserList;