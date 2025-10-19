import { useEffect, useState } from "react";
import { FiX } from "react-icons/fi";

const PlayListCreate = ({ onClose, onCreate }) => {
  return (
      <div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50 p-4">
        <div className="bg-white rounded-lg w-full max-w-2xl">
          <div className="flex items-center justify-between p-4 border-b border-gray-200">
            <h2 className="text-xl font-bold">플레이 리스트 생성</h2>
            <button
              onClick={onClose}
              className="p-2 hover:bg-gray-100 rounded-full transition-colors"
            >
            <FiX size={24} />
          </button>
        </div>
          <div className="flex flex-row">
          <div className="w-1/2 border-r">
          <div className="p-4">
            <label className="block mb-2 font-semibold text-gray-700" htmlFor="playlist-name">
              플레이 리스트 이름
            </label>
            <input
              id="playlist-name"
              name="playlist-name"
              className="w-full border p-2 rounded-lg focus:ring-2 focus:ring-blue-400"
              placeholder="플레이 리스트 이름을 입력하세요"
            />
          </div>
          <div className="p-4">
            <label className="block mb-2 font-semibold text-gray-700" htmlFor="playlist-description">
              설명
            </label>
            <textarea
              id="playlist-description"
              name="playlist-description"
              className="w-full border p-2 rounded-lg focus:ring-2 focus:ring-blue-400"
              placeholder="플레이 리스트 설명을 입력하세요"
              rows={3}
            />
          </div>
          <div className="p-4 w-full border-b border-gray-200">
            {/* 추가된 음악 */}
            <h3 className="font-semibold mb-2">추가된 음악</h3>
            <div className="max-h-48 overflow-y-auto">
              {/* 추가된 음악 목록 */}
              <p className="text-gray-500">추가된 음악이 여기에 표시됩니다.</p>
            </div>
          </div>
          </div>
          <div className="w-1/2 border-l p-4">
            {/* 음악 검색 및 추가 */}
            
            <h3 className="font-semibold mb-2">음악 검색</h3>
            <input
              type="text"
              className="w-full border p-2 rounded-lg focus:ring-2 focus:ring-blue-400"
              placeholder="음악을 검색하세요"
            />
            <div className="max-h-48 overflow-y-auto m-4">
              {/* 검색 결과 목록 */}
              <p className="text-gray-500">검색 결과가 여기에 표시됩니다.</p>
            </div>
          </div>
          </div>
          <div className="flex justify-end p-4 border-t border-gray-200">
            <button
              onClick={onClose}
              className="bg-gray-300 text-gray-700 px-4 py-2 rounded-lg mr-2 hover:bg-gray-400 transition-colors"
            >
              취소
            </button>
            <button
              onClick={onCreate}
              className="bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600 transition-colors"
            >
              생성
            </button>
          </div>
        </div>
    </div>
  );
};

export default PlayListCreate;