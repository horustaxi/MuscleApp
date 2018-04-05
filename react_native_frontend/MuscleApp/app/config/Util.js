export function capitalizeFirst(txt) {
    return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
}

export function capitalizeAll(str) {
    return str.replace(/\w\S*/g, (txt) =>
            txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase());
}

export function arrayToString(mainMuscles) {
  return mainMuscles.map(muscle => muscle.name).join(', ');
}
