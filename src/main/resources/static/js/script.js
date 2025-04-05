
function toggleOcultado(icon) {
    const formDiv = icon.parentElement.querySelector('.form-popup');
    formDiv.classList.toggle('ocultado');
}

document.addEventListener('click', function(event) {
    document.querySelectorAll('.form-popup').forEach(function(popup) {
        if (!popup.contains(event.target) && !event.target.classList.contains('fa-cart-plus')) {
            popup.classList.add('ocultado');
        }
    });
});