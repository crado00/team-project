import Avatar from "../common/Avatar";

const ProfileInfo = () => {
  return (
    <div className="p-4 border-divider bg-amber-400">
        <div className="flex items-start space-x-4 justify-between">
            <div className="relative">
              <div className="flex items-center space-x-4">
                <Avatar size="xlarge" />
                <div>
                  <h1 className="mb-3">유저 이름</h1>
                  <p>플레이 리스트 수</p>
                </div>
              </div>
            </div>
            <div className="self-center mr-3">
              <button className="px-4 py-2 bg-blue-500 text-white rounded-full hover:bg-blue-600 transition">
                Edit Profile
              </button>
            </div>
            
        </div>
        
    </div>
  );
};

export default ProfileInfo;