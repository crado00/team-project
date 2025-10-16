import Button from "../common/Button";
import PlayListCard from "./PlayListCard";

const ProfilePlayList = ({ playList, deletePlayList, createPlayList}) => {

  return (
      <div className="p-4 border-divider flex gap-4 flex-wrap">
        <div className="w-full flex justify-end mb-4">
          <Button
            title="플레이 리스트 생성"
            customStyles="border border-black bg-white hover:bg-gray-300 transition"
            style={{color: "black"}}
            onClick={createPlayList}
          />
        </div>
        {playList.map((playList) => (
            <PlayListCard key={playList.id} {...playList} deletePlayList={deletePlayList}/>
        ))}
        
      </div>
    );
};

export default ProfilePlayList;