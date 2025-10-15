import ProfileInfo from "../components/profile/ProfileInfo";
import ProfilePlayList from "../components/profile/ProfilePlayList";

const Profile = () => {
  return <div className="bg-red-100">
    <div className="bg-white min-h-screen max-w-2xl mx-auto flex flex-col">
      <ProfileInfo />

      <div className="bg-green-300 flex-grow">
        <ProfilePlayList />
      </div>
    </div>
  </div>;
};

export default Profile;