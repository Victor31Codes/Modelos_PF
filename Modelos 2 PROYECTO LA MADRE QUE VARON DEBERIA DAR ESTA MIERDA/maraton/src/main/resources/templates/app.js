const getElement = (selector) => {
  const element = document.querySelector(selector);

  if (element) return element;
  throw Error(
    `Please double check your class names, there is no ${selector} class`
  );
};

const links = getElement(".nav_links");
const navBtnDOM = getElement(".burger_btn");

navBtnDOM.addEventListener("click", () => {
  links.classList.toggle("show_links");
});
