const Button = ({ type, title, customStyles, onClick, disabled, style }) => {
  //customStyles: 추가적인 스타일을 적용할 수 있도록 함
  //style: customStyles에서 적용 안되는 스타일의 적용 용
  return (
    <button
      disabled={disabled}
      type={type}
      className={`px-6 py-2 font-semibold text-white
        bg-blue-500 rounded-lg 
        hover:bg-blue-600 transition
        flex items-center justify-center ${customStyles}`}
      style={style}
      onClick={onClick}
    >
      {title}
    </button>
  );
};

export default Button;