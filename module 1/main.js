/**
 * ==========================================================================
 * JavaScript Logic Pipeline - "Local Community Event Portal" [cite: 514]
 * ==========================================================================
 */

// 1. Core Verification Trace Logs & Setup Checks [cite: 516]
console.log("Welcome to the Community Portal"); // Logging baseline configuration verification track [cite: 520]

// 5. Prototype Oriented Data Structures / Object Constructor definitions [cite: 537, 540]
class CommunityEvent {
    constructor(id, title, category, price, seats) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.seats = seats;
    }
    
    checkAvailability() {
        return this.seats > 0; // Availability logical confirmation mapping [cite: 541]
    }
}

// 6. Dynamic Event Registry arrays [cite: 543]
let localEventsRegistry = [
    new CommunityEvent(1, "Acoustic Session Night", "music", 15, 4),
    new CommunityEvent(2, "Artistic Canvas Seminar", "art", 0, 12),
    new CommunityEvent(3, "Baking Workshop", "workshop", 25, 0) // Full Event Test Node
];

// 7. DOM Manipulation & Element Attachment routines 
function renderPortalDashboardCards() {
    const wrapper = document.getElementById("dynamicCardWrapper");
    if (!wrapper) return;
    wrapper.innerHTML = ""; // Wipe baseline configuration tree nodes

    // ES6 Destructuring loop mapping arrays cleanly [cite: 531, 571]
    localEventsRegistry.forEach(({ id, title, category, price, seats }) => {
        // 3. Conditional filter logic checking capacity [cite: 526, 530]
        if (seats <= 0) return; 

        const card = document.createElement("div");
        card.className = "eventCard";
        card.innerHTML = `
            <h4>${title}</h4>
            <p><strong>Type:</strong> ${category.toUpperCase()} | <strong>Price:</strong> $${price}</p>
            <p><strong>Available Inventory Seats:</strong> <span id="seatCount-${id}">${seats}</span></p>
            <button onclick="executeDirectRegistration(${id})">Book Ticket</button>
        `;
        wrapper.appendChild(card); // Append constructed elements directly onto view trees [cite: 554]
    });
}

// 2 & 4. State Management Processing via Registration Closures [cite: 522, 533]
function createRegistrationTracker() {
    let combinedRegistrationsCount = 0; // Encapsulated baseline closure state trace variable [cite: 536]
    return function(eventName) {
        combinedRegistrationsCount++;
        console.log(`Global registration event count updated. Current pool sizing: ${combinedRegistrationsCount}`);
        return `Successfully reserved space for: ${eventName}`;
    }
}
const logSystemRegistrationEvent = createRegistrationTracker();

function executeDirectRegistration(eventId) {
    try {
        const targetEvent = localEventsRegistry.find(e => e.id === eventId);
        if (!targetEvent || !targetEvent.checkAvailability()) {
            throw new Error("Unable to complete transaction: Seat inventory empty."); // Error catching constraints [cite: 532]
        }
        
        targetEvent.seats--; // Decrement structural primitives safely [cite: 525]
        const statusMsg = logSystemRegistrationEvent(targetEvent.title);
        
        alert(statusMsg); // Alert notifications confirmed on asset loading profiles [cite: 521]
        renderPortalDashboardCards(); // Force interface update loop updates [cite: 554]
    } catch (err) {
        alert(err.message);
    }
}

// 6 & 11. Form Submission Processing & Validation Logic [cite: 468, 573]
const registrationForm = document.getElementById("registrationForm");
if (registrationForm) {
    registrationForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Halt document processing redirects [cite: 576]
        
        const name = document.getElementById("residentName").value.trim();
        const email = document.getElementById("residentEmail").value.trim();
        const selectedType = document.getElementById("eventType").value;

        if (!name || !email) {
            document.getElementById("formOutputStatus").innerText = "Validation exception: Form fields incomplete.";
            return;
        }

        // 8. Commit values to LocalStorage [cite: 491, 495]
        localStorage.setItem("preferred_category", selectedType);
        
        // Form compilation verification message printout [cite: 474]
        document.getElementById("formOutputStatus").innerHTML = `Registration validated for ${name}. Preferred setting cached!`;
        
        // 12. Simulate Background Network Server communication streams [cite: 578, 580]
        simulateServerPostPayload({ name, email, selectedType });
    });
}

// 12. Async Processing via Fetch APIs with Server Simulations [cite: 578]
function simulateServerPostPayload(payloadData) {
    console.log("Transmitting payload trace to network nodes:", JSON.stringify(payloadData));
    setTimeout(() => {
        console.log("Server API transactions committed successfully via structural mock logic nodes.");
    }, 1000);
}

// 6 & 8. Interaction handling and character counting parameters [cite: 476, 491]
const textFeedbackArea = document.getElementById("feedbackText");
if (textFeedbackArea) {
    textFeedbackArea.addEventListener("input", function() {
        // Track keystroke updates dynamically into status view items 
        document.getElementById("charCount").innerText = this.value.length;
    });
    
    // Blur Event Integration [cite: 479]
    textFeedbackArea.addEventListener("blur", function() {
        console.log("Feedback textbox input element focus detached.");
    });
}

// 8. Retrieve Preference Storage configurations on execution init [cite: 491, 496]
window.addEventListener("DOMContentLoaded", () => {
    const cachedCategoryPreference = localStorage.getItem("preferred_category");
    if (cachedCategoryPreference && document.getElementById("eventType")) {
        document.getElementById("eventType").value = cachedCategoryPreference;
        console.log(`Preferences restored. Initialized selection to: ${cachedCategoryPreference}`);
    }
    renderPortalDashboardCards(); // Bind data layout elements to screen [cite: 551]
});

// Clear preferences handler routines [cite: 497]
const clearPrefBtn = document.getElementById("clearPrefBtn");
if (clearPrefBtn) {
    clearPrefBtn.addEventListener("click", () => {
        localStorage.clear();
        sessionStorage.clear();
        if(registrationForm) registrationForm.reset();
        alert("Local tracking preferences wiped successfully.");
    });
}

// 9. Geolocation Integrations [cite: 498, 501]
const geoBtn = document.getElementById("geoBtn");
if (geoBtn) {
    geoBtn.addEventListener("click", () => {
        const geoDisplay = document.getElementById("geoDisplay");
        if (!navigator.geolocation) {
            geoDisplay.innerText = "Location telemetry profiles unsupported on this browser client core.";
            return;
        }

        const options = { enableHighAccuracy: true, timeout: 5000 }; // High accuracy setup [cite: 505]
        
        navigator.geolocation.getCurrentPosition(
            (pos) => {
                geoDisplay.innerHTML = `<strong>Lat:</strong> ${pos.coords.latitude.toFixed(4)} | <strong>Lng:</strong> ${pos.coords.longitude.toFixed(4)}`;
            },
            (err) => {
                geoDisplay.innerText = `Telemetry failed: ${err.message}`; // Error catching [cite: 504]
            }, 
            options
        );
    });
}

// 7. Prevent accidental exit if editing forms [cite: 490]
window.onbeforeunload = function() {
    if (document.getElementById("residentName")?.value.length > 0) {
        return "You have pending form data changes. Are you sure you want to navigate away?";
    }
};