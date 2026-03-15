/**
 * 
 */

const stickyHeader = document.getElementById('sticky-header');
const scrollPoint = 100;

window.addEventListener('scroll', () => {
  if (window.scrollY > scrollPoint) {
    stickyHeader.classList.add('sticky-header--scrolled');
  } else {
    stickyHeader.classList.remove('sticky-header--scrolled');
  }
});