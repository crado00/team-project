const Input = ({
  type = "text",
  placeholder,
  value,
  onChange,
  name,
  required = false,
  className = "",
}) => {
  return (
    <input
      type={type}
      name={name}
      placeholder={placeholder}
      value={value}
      onChange={onChange}
      required={required}
      className={`w-full px-4 py-3 bg-gray-50/50 border border-gray-200 rounded-xl text-base focus:outline-none focus:border-pink-400 focus:ring-2 focus:ring-pink-100 transition-all`}
    />
  );
};

export default Input;
