const PlayListCard = (
    user
) => {
    const userId = user?.id;
  return (
      <div className="w-40 h-60 flex flex-col gap-6 rounded-xl border">
        <img
            src="https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=687&q=80"
            alt={userId}
            className="w-full h-40 rounded-t-xl object-cover"
        />
      </div>
    );
};

export default PlayListCard;