import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import ProfileInfo from "../components/profile/ProfileInfo";
import ProfilePlayList from "../components/play-list/ProfilePlayList";
import useUserStore from "../store/userstore";
import EditProfile from "../components/profile/editProfile";
import PlayListCreate from "../components/play-list/playlistcreate";
const Profile = () => {
  const { userId } = useParams();
  const { userProfile, getUserProfile } = useUserStore();

    const [showEditModal, setShowEditModal] = useState(false);
    const [isCreatePlayListModalOpen, setIsCreatePlayListModalOpen] = useState(false);

    const user = { id: userId, name: "User " + userId };
    
    // 임시 데이터
    const [playlist, setPlayList] = useState([
        { id: 1, name: "playlist 1", explanation: "hello" },
        { id: 2, name: "User 2", explanation: "hi" },
        { id: 3, name: "User 3", explanation: "good" },
        { id: 4, name: "User 4", explanation: "day" },
        { id: 5, name: "User 5", explanation: "nice" },
    ]);

    const deletePlayList = (id) => {
      setPlayList(playlist.filter((pl) => pl.id !== id));
      //임시
    }

    const createPlayList = (newPlayList) => {
      setIsCreatePlayListModalOpen(true);
      //임시
    }

    useEffect(() => {
      getUserProfile(userId);
    }, [userId, getUserProfile]);



  const playListSize = playlist ? playlist.length : 0;
  return <div className="bg-red-100">
    <div className="bg-white min-h-screen max-w-2xl mx-auto flex flex-col">

      <ProfileInfo user={ user } playListSize={playListSize} onEditProfile={() => setShowEditModal(true)}/>

      <div className="flex-grow">
        <ProfilePlayList playList={playlist} deletePlayList={deletePlayList} createPlayList={createPlayList}/>
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
    {isCreatePlayListModalOpen && (
        <PlayListCreate
        onClose={() => setIsCreatePlayListModalOpen(false)}
        />
    )}
  </div>;
};

export default Profile;