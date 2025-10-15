import ProfileHeader from "../components/profile/ProfileHeader";
import ProfileInfo from "../components/profile/ProfileInfo";

const Profile = () => {
  return <div className="bg-red-100">
    <div className="bg-white min-h-screen max-w-2xl mx-auto flex flex-col">
      <ProfileHeader username={"확인용"}/>

      <ProfileInfo />

      <div className="bg-green-300 text-2xl">
        <p>내 플레이 리스트</p>
      </div>
    </div>
  </div>;
};

export default Profile;