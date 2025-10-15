import PlayListCard from "../play-list/PlayListCard";

const ProfilePlayList = () => {

    const user = [
        { id: 1, name: "User 1" },
        { id: 2, name: "User 2" },
        { id: 3, name: "User 3" },
        { id: 4, name: "User 4" },
        { id: 5, name: "User 5" },
    ]
  return (
      <div className="p-4 border-divider flex gap-4 flex-wrap bg-blue-200">
        {user.map((user) => (
            <PlayListCard key={user.id} {...user} />
        ))}
        
      </div>
    );
};

export default ProfilePlayList;