import Button from "../common/Button";

const PlayListCard = ({ id, name, explanation, deletePlayList }
) => {

  return (
      <div className="w-50 h-80 flex flex-col gap-2 rounded-xl border">
        <img
            src="https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=687&q=80"
            alt={id}
            className="w-full h-50 rounded-t-xl object-cover"
        />
        <div className="px-2 pb-2 flex flex-col gap-1">
            <h2 className="font-semibold text-lg">{name}</h2>
            <p className="text-sm text-gray-500">{explanation}</p>
        </div>
        <div className="px-2 pb-2 mt-auto">
          <Button
            title="삭제"
            customStyles="border border-black bg-red-500 w-full text-sm py-1 h-8"
            onClick={() => deletePlayList(id)}
            />
        </div>
      </div>
    );
};

export default PlayListCard;