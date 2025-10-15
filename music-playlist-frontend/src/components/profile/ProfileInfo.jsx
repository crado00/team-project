import Avatar from "../common/Avatar";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";

const ProfileInfo = ({ user, playListSize, onEditProfile }) => {


      useEffect(() => {
          // 페이지가 로드될 때 스크롤을 맨 위로 이동
          console.log(user);
      }, []);
  return (
    <div className="p-4 border-divider border-b">
        <div className="flex items-start space-x-4 justify-between">
            <div className="relative">
              <div className="flex items-center space-x-4">
                <Avatar size="xlarge" />
                <div>
                  <h1 className="mb-3">{user?.name}</h1>
                  <p>플레이 리스트: {playListSize}</p>
                </div>
              </div>
            </div>
            <div className="self-center mr-3">
              <button
                onClick={onEditProfile}
                className="px-4 py-1 border border-gray-300 rounded-md text-sm font-medium hover:bg-gray-50"
              >
                Edit Profile
              </button>
            </div>
            
        </div>
        
    </div>
  );
};

export default ProfileInfo;