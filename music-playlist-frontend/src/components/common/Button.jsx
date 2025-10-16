const Button = ({ type, title, customStyles, onClick, disabled }) => {
  return (
    <button
      disabled={disabled}
      type={type}
      className={`px-6 py-2 font-semibold text-white bg-blue-500 rounded-lg hover:bg-blue-600 transition ${customStyles}`}
      onClick={onClick}
    >
      {title}
    </button>
  );
};

export default Button;