import { useEffect, useState } from "react";
import { FiX } from "react-icons/fi";

const PlayListCreate = ({ onClose, onCreate }) => {
  return (
      <div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50 p-4">
        <div className="bg-white rounded-lg w-full max-w-md">
          <div className="flex items-center justify-between p-4 border-b border-gray-200">
            <h2 className="text-xl font-bold">Edit Profile</h2>
            <button
              onClick={onClose}
              className="p-2 hover:bg-gray-100 rounded-full transition-colors"
            >
            <FiX size={24} />
          </button>
        </div>


        
        </div>
    </div>
  );
};

export default PlayListCreate;