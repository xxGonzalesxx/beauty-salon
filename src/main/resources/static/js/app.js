// Основные функции JavaScript
document.addEventListener('DOMContentLoaded', function() {
    // Инициализация календаря для записи
    initBookingForm();

    // Обработка форм
    initForms();
});

function initBookingForm() {
    const serviceSelect = document.getElementById('serviceSelect');
    const masterSelect = document.getElementById('masterSelect');

    if (serviceSelect && masterSelect) {
        serviceSelect.addEventListener('change', function() {
            const serviceId = this.value;
            if (serviceId) {
                loadMastersByService(serviceId);
            }
        });
    }
}

function loadMastersByService(serviceId) {
    fetch(`/masters/service/${serviceId}`)
        .then(response => response.json())
        .then(masters => {
            const masterSelect = document.getElementById('masterSelect');
            masterSelect.innerHTML = '<option value="">Выберите мастера</option>';

            masters.forEach(master => {
                const option = document.createElement('option');
                option.value = master.id;
                option.textContent = `${master.firstName} ${master.lastName} - ${master.specialization}`;
                masterSelect.appendChild(option);
            });
        })
        .catch(error => console.error('Error loading masters:', error));
}

function initForms() {
    const forms = document.querySelectorAll('form');
    forms.forEach(form => {
        form.addEventListener('submit', function(e) {
            const submitBtn = this.querySelector('button[type="submit"]');
            if (submitBtn) {
                submitBtn.disabled = true;
                submitBtn.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Загрузка...';
            }
        });
    });
}