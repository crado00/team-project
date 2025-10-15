const ProfileInfo = () => {
  return (
    <div className="p-4 border-divider bg-amber-400">
        <div className="flex items-start space-x-4 justify-between">
            <div className="relative">
            <h2>유저 이름</h2>
            </div>
            <button>
                Edit Profile
            </button>
        </div>
        
    </div>
  );
};

export default ProfileInfo;