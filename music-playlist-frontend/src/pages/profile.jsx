import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import ProfileInfo from "../components/profile/ProfileInfo";
import ProfilePlayList from "../components/profile/ProfilePlayList";
import useUserStore from "../store/userstore";
import EditProfile from "../components/profile/editProfile";

const Profile = () => {
  const { userId } = useParams();
  const { userProfile, getUserProfile } = useUserStore();

    const [showEditModal, setShowEditModal] = useState(false);
    
    const user = { id: userId, name: "User " + userId };

    
    // 임시 데이터
    const playlist = [
        { id: 1, name: "playlist 1", explanation: "hello" },
        { id: 2, name: "User 2", explanation: "hi" },
        { id: 3, name: "User 3", explanation: "good" },
        { id: 4, name: "User 4", explanation: "day" },
        { id: 5, name: "User 5", explanation: "nice" },
    ]

  const playListSize = playlist ? playlist.length : 0;
  return <div className="bg-red-100">
    <div className="bg-white min-h-screen max-w-2xl mx-auto flex flex-col">

      <ProfileInfo user={ user } playListSize={playListSize} onEditProfile={() => setShowEditModal(true)}/>

      <div className="flex-grow">
        <ProfilePlayList playList={playlist}/>
      </div>
    </div>
    {showEditModal && (
        <EditProfile
        onClose={() => {
            setShowEditModal(false);
            getUserProfile(userId);
          }}
          />
    )}
  </div>;
};

export default Profile;