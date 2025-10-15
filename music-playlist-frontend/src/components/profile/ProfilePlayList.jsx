import PlayListCard from "../play-list/PlayListCard";

const ProfilePlayList = ({ playList}) => {


  return (
      <div className="p-4 border-divider flex gap-4 flex-wrap">
        {playList.map((playList) => (
            <PlayListCard key={playList.id} {...playList} />
        ))}
        
      </div>
    );
};

export default ProfilePlayList;